FROM hihoall/debianmavenjavatomcatglassfish

MAINTAINER VIACHESLAV

ENV JAVA_OPTS -Dfile.encoding=UTF8 -Duser.language=ru -Duser.region=RU -Djavax.xml.parsers.DocumentBuilderFactory=com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl -Djavax.xml.parsers.SAXParserFactory=com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl

COPY ./autodeploy /glassfish5/glassfish/domains/domain1/autodeploy
COPY ./glassfish /glassfish5/glassfish

CMD ["/glassfish5/glassfish/bin/asadmin", "start-domain", "-v"]

#command to run: docker-compose up