package ua.khpi.bibik.hospital_system.db.connectionpool;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeNoException;

import java.sql.Connection;

import org.junit.Test;

import ua.khpi.bibik.hospital_system.db.connectionpool.exception.ConnectionPoolException;

public class ConnectionPoolTest {

	@Test
	public void testTakeConnection() {
		try {
			Connection connection = ConnectionPool.getInstance().takeConnection();
			assertNotNull(connection);
		} catch (ConnectionPoolException e) {
			assumeNoException(e);
			e.printStackTrace();
		}
	}

}
