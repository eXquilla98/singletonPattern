package org.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class printer {
  private static volatile printer publicPrinter;
  private static volatile Connection connection;

  private printer() {

    if (publicPrinter != null) {

      throw new RuntimeException("please use publicPrinter");

    }
  }

  public static printer getPublicPrinter() {
    if (publicPrinter == null) {
      synchronized (printer.class) {
        if (publicPrinter == null) {
          publicPrinter = new printer();
        }
      }
    }

    return publicPrinter;
  }

  public Connection getConnection() {
    if (connection == null) {
      synchronized (printer.class) {
        if (connection == null) {
          String url = "jdbc:derby:memory:sample;create =true";
          try {
            connection = DriverManager.getConnection(url);
          } catch (SQLException e) {
            e.printStackTrace();
          }
        }
      }
    }
    return connection;
  }
}

