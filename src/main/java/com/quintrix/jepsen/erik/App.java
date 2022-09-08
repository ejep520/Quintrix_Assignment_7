package com.quintrix.jepsen.erik;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
  public static void main(String[] args) {
    OutputStream outputStream = null;
    Path outFile = Paths.get("outFile.json");
    ObjectMapper mapper = new ObjectMapper();
    Person fred = new Person(1, "Fred", "Mbogo, W.D.", 3,
        new String[] {"Witchcraft", "Medicine", "Holistic Medicine", "Acupuncture", "Doll Craft"});
    try {
      if (Files.exists(outFile))
        Files.delete(outFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      outputStream = Files.newOutputStream(outFile, StandardOpenOption.CREATE);
      mapper.writeValue(outputStream, fred);
      System.out.println(mapper.writeValueAsString(fred));
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (outputStream != null)
          outputStream.close();
      } catch (IOException i) {
        i.printStackTrace();
      }
    }
  }
}
