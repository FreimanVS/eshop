package com.freimanvs.shops.eshop.utils;

import com.freimanvs.shops.eshop.dao.interfaces.RoleDAO;
import com.freimanvs.shops.eshop.entities.Role;
import com.freimanvs.shops.eshop.entities.User;
import com.freimanvs.shops.eshop.services.interfaces.UserService;
import com.freimanvs.shops.eshop.utils.interfaces.InitDBBean;

import javax.ejb.*;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Set;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class InitDataBase implements InitDBBean {

    @PersistenceContext(unitName = "eshopmysql")
    private EntityManager em;

    @EJB
    private RoleDAO roleDAO;

    @Inject
    private UserService userService;

    public void init() {
        createTables();
        addRoles();
        addAdmins();
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

    private void addRoles() {
        Role userDB = roleDAO.getById(1L);
        if (userDB == null) {
            Role user = new Role();
            user.setName("user");
            roleDAO.add(user);
        }

        Role adminDB = roleDAO.getById(2L);
        if (adminDB == null) {
            Role admin = new Role();
            admin.setName("admin");
            roleDAO.add(admin);
        }
    }

    private void addAdmins() {
        if (userService.getByUnique("login", "admin") == null) {
            User admin = new User();
            admin.setLogin("admin");
            admin.setPassword("admin");
            admin.setEmail("admin@admin.ru");

            Set<Role> roles = admin.getRoles();
            roles.add(roleDAO.getById(2L));

            userService.add(admin);
        }
    }
}
