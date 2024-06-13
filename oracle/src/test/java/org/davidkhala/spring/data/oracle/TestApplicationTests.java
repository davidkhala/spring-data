package org.davidkhala.spring.data.oracle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcConnectionDetails;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.oracle.OracleContainer;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Testcontainers
class TestApplicationTests {

    @Container
    @ServiceConnection
    public static OracleContainer oracleContainer = new OracleContainer("gvenzl/oracle-free:slim-faststart");

    @Autowired
    R2dbcConnectionDetails connectionDetails;
    @Test
    void contextLoads() {

        assertTrue(oracleContainer.isRunning());
        System.out.println(connectionDetails.getConnectionFactoryOptions());

    }

}
