package com.freimanvs.shops.eshop.utils;

import com.freimanvs.shops.eshop.dao.interfaces.GoodsDAO;
import com.freimanvs.shops.eshop.dao.interfaces.OrderDAO;
import com.freimanvs.shops.eshop.dao.interfaces.RoleDAO;
import com.freimanvs.shops.eshop.dao.interfaces.UserDAO;
import com.freimanvs.shops.eshop.entities.Goods;
import com.freimanvs.shops.eshop.entities.Role;
import com.freimanvs.shops.eshop.entities.User;
import com.freimanvs.shops.eshop.entities.interfaces.Idable;
import com.freimanvs.shops.eshop.utils.interfaces.InitDBBean;
import org.apache.log4j.Logger;

import javax.ejb.*;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.*;
import java.util.Comparator;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class InitDataBase implements InitDBBean {

    private static final Logger LOGGER = Logger.getLogger(InitDataBase.class);

    private static final String PATH_TO_ROLES = "/presentational_filling_db/roles.json";
    private static final String PATH_TO_GOODS = "/presentational_filling_db/goods.json";
    private static final String PATH_TO_USERS = "/presentational_filling_db/users.json";

    private String URL;
    private String LOGIN;
    private String PASSWORD;

    @PersistenceContext(unitName = "eshopmysql")
    private EntityManager em;

    @Inject
    private FileManager roleFileManager;

    @EJB
    private RoleDAO roleDAO;

    @EJB
    private UserDAO userDAO;

    @EJB
    private GoodsDAO goodsDAO;

    @EJB
    private OrderDAO orderDAO;

    public void init() {
        createTables();
        fill();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    private void createTables() {
        em.createNativeQuery("CREATE SCHEMA IF NOT EXISTS eshop;").executeUpdate();
        em.createNativeQuery("USE eshop;").executeUpdate();

        em.createNativeQuery("CREATE TABLE IF NOT EXISTS eshop.user (\n" +
                "id BIGINT NOT NULL AUTO_INCREMENT,\n" +
                "login VARCHAR(100) NOT NULL UNIQUE,\n" +
                "password VARCHAR(100) NOT NULL,\n" +
                "email VARCHAR(100) NOT NULL,\n" +
                "PRIMARY KEY (id)\n" +
                ");").executeUpdate();

        em.createNativeQuery("CREATE TABLE IF NOT EXISTS eshop.order (\n" +
                "id BIGINT NOT NULL AUTO_INCREMENT,\n" +
                "name VARCHAR(100) NOT NULL,\n" +
                "phoneNumber VARCHAR(100) NOT NULL,\n" +
                "street VARCHAR(100) NOT NULL,\n" +
                "houseNumber VARCHAR(100) NOT NULL,\n" +
                "apartment VARCHAR(100) NOT NULL,\n" +
                "floor VARCHAR(100) NOT NULL,\n" +
                "codeEntrance VARCHAR(100) NOT NULL,\n" +
                "comment VARCHAR(10000) NOT NULL,\n" +
                "user_id BIGINT NOT NULL,\n" +
                "PRIMARY KEY (id),\n" +
                "CONSTRAINT fk_order_user FOREIGN KEY (user_id) REFERENCES user(id)\n" +
                ");").executeUpdate();

        em.createNativeQuery("CREATE TABLE IF NOT EXISTS eshop.goods (\n" +
                "id BIGINT NOT NULL AUTO_INCREMENT,\n" +
                "name VARCHAR(100) NOT NULL,\n" +
                "price DOUBLE NOT NULL,\n" +
                "img VARCHAR(500) NOT NULL,\n" +
                "PRIMARY KEY (id)\n" +
                ");").executeUpdate();

        em.createNativeQuery("CREATE TABLE IF NOT EXISTS eshop.order_goods (\n" +
                "order_id BIGINT NOT NULL,\n" +
                "goods_id BIGINT NOT NULL,\n" +
                "CONSTRAINT fk_order_id FOREIGN KEY (order_id) REFERENCES eshop.order(id),\n" +
                "CONSTRAINT fk_goods_id FOREIGN KEY (goods_id) REFERENCES eshop.goods(id)\n" +
                ");").executeUpdate();

        em.createNativeQuery("CREATE TABLE IF NOT EXISTS eshop.role (\n" +
                "id BIGINT NOT NULL AUTO_INCREMENT,\n" +
                "name VARCHAR(100) NOT NULL,\n" +
                "PRIMARY KEY (id),\n" +
                "CONSTRAINT uniqRole UNIQUE (name)\n" +
                ");").executeUpdate();

        em.createNativeQuery("CREATE TABLE IF NOT EXISTS eshop.user_role (\n" +
                "user_id BIGINT NOT NULL,\n" +
                "role_id BIGINT NOT NULL,\n" +
                "PRIMARY KEY (user_id, role_id),\n" +
                "CONSTRAINT fk_user_role_user_id FOREIGN KEY (user_id) REFERENCES eshop.user(id),\n" +
                "CONSTRAINT fk_user_role_role_id FOREIGN KEY (role_id) REFERENCES role(id)\n" +
                ");").executeUpdate();
    }

    private void fill() {
        List<Role> roles = (List<Role>)roleFileManager.fromJsonArrayResourceToList(PATH_TO_ROLES, Role.class);
        List<User> users = (List<User>)roleFileManager.fromJsonArrayResourceToList(PATH_TO_USERS, User.class);
        List<Goods> goods = (List<Goods>)roleFileManager.fromJsonArrayResourceToList(PATH_TO_GOODS, Goods.class);

        Comparator<? extends Idable> asc = (Comparator.comparingInt(o -> (int) o.getId()));

        roles.stream().sorted((Comparator<Role>)asc)
                .filter(r -> roleDAO.getByUnique("name", r.getName()) == null)
                .forEach(roleDAO::add);

        users.stream().sorted((Comparator<User>)asc)
                .filter(u -> userDAO.getByUnique("login", u.getLogin()) == null)
                .forEach(userDAO::add);

        goods.stream().sorted((Comparator<Goods>)asc)
                .filter(g -> goodsDAO.getByUnique("name", g.getName()) == null)
                .forEach(goodsDAO::add);

    }

    public void waitForInitDB(String ip) {
        URL = "jdbc:mysql://" + ip + ":3306/sys?useSSL=false";
        LOGIN = "root";
        PASSWORD = "pass";

        //to sleep until a database is ready
        while (!connIsOk()) {
            LOGGER.warn(String.format("DB is not ready yet or incorrect data:\r\n" +
                    "URL: %s\r\n" +
                    "LOGIN: %s\r\n" +
                    "PASSWORD: %s\r\n", URL, LOGIN, PASSWORD));
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                LOGGER.error(e.getLocalizedMessage());
                e.printStackTrace();
            }
        }
    }

    private boolean connIsOk() {
        try {
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
        } catch (Exception e) {
            return false;
        }

        try (Connection conn = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT 1")) {

            StringBuilder sb = new StringBuilder();
            while(resultSet.next()){
                sb.append(resultSet.getInt("1"));
            }

            return "1".equals(sb.toString());

        } catch (SQLException e) {
            return false;
        }
    }
}
