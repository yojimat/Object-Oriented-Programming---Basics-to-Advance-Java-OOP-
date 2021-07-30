package methodsExercises;
public class StringProcessor {
  public static final String INPUT_DATA = "Login;Name;Email" + System.lineSeparator()
      + "peterson;Chris Peterson;peterson@outlook.com" + System.lineSeparator() + "james;Derek James;james@gmail.com"
      + System.lineSeparator() + "jackson;Walter Jackson;jackson@gmail.com" + System.lineSeparator()
      + "gregory;Mike Gregory;gregory@yahoo.com";

  public static void main(String[] args) {
    System.out.println("===== Convert 1 demo =====");
    System.out.println(convert1(INPUT_DATA));

    System.out.println("===== Convert 2 demo =====");
    System.out.println(convert2(INPUT_DATA));

  }

  public static String convert1(String input) {
    String[] inputData = input.split("\\n");
    StringBuilder output = new StringBuilder();
    boolean jumpOne = true;
    for (String data : inputData) {
      if (jumpOne) {
        jumpOne = false;
        continue;
      }
      String[] cleanData = data.split(";");
      output.append(cleanData[0]).append(" ==> ").append(cleanData[2]).append(System.lineSeparator());
    }
    return output.toString();
  }

  public static String convert2(String input) {
    String[] inputData = input.split("\\n");
    StringBuilder output = new StringBuilder();
    boolean jumpOne = true;
    for (String data : inputData) {
      if (jumpOne) {
        jumpOne = false;
        continue;
      }
      String[] cleanData = data.split(";");
      output.append(cleanData[1]).append(" (email: ").append(cleanData[2]).append(")").append(System.lineSeparator());
    }
    return output.toString();
  }

}
