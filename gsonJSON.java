{
  NAME:"Albert Attard",
  P_LANGUAGE:"Java",
  LOCATION:"Malta",
  EXAM: {
    SUBJECT:"Programming",
    GRADE:4.5
  }  
}
public class Person {
  private String NAME;
  private String LOCATION;
  private Exam EXAM;

  // Getters and setters are not required for this example.
  // GSON sets the fields directly using reflection.

  @Override
  public String toString() {
    return NAME + " - " + LOCATION + " (" + EXAM + ")";
  }
}
public class Exam {
  private String SUBJECT;
  private double GRADE;

  // Getters and setters are not required for this example.
  // GSON sets the fields directly using reflection.

  @Override
  public String toString() {
    return SUBJECT + " - " + GRADE;
  }

public class JsonToJava {
public static void main(final String[] args) throws IOException {
    try (Writer writer = new FileWriter("Output.json")) {
    try (final Writer writer = new OutputStreamWriter(new FileOutputStream("Output.json"), "UTF-8")) {
      final Gson gson = new GsonBuilder().create();
      gson.toJson("Hello", writer);
      gson.toJson(123, writer);
    }
    
     try (final Reader reader = new InputStreamReader(JsonToJava.class.getResourceAsStream("/Server2.json"), "UTF-8")) {
      final Gson gson = new GsonBuilder().create();
      final Person p = gson.fromJson(reader, Person.class);
      System.out.println(p);
    }
  }
  
  public static void main(final String[] args) throws IOException {
    try (Reader reader = new InputStreamReader(JsonToJava.class.getResourceAsStream("/Server1.json"))) {
      final Gson gson = new GsonBuilder().create();
      final Person p = gson.fromJson(reader, Person.class);
      System.out.println(p);
    }
  }
