//Дана json-строка (можно сохранить в файл и читать из файла)
//[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
public class Task2 {
    public static void main(String[] args) {
      String json = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
      String[] params = ParseJsonList(json);
      String[] formattedStrings = getFormattedStrings(params);
      printArray(formattedStrings);
    }
  
    public static String[] ParseJsonList(String jsonList) {
      String[] params = jsonList.split("},");
      for (int i = 0; i < params.length; i++) {
        params[i] = params[i].replace("\"", "");
        params[i] = params[i].replace("{", "");
        params[i] = params[i].replace("}", "");
        params[i] = params[i].replace("[", "");
        params[i] = params[i].replace("]", "");
        params[i] = params[i].replace("фамилия:", "");
        params[i] = params[i].replace("оценка:", "");
        params[i] = params[i].replace("предмет:", "");
      }
      return params;
    }
  
    public static String[] getFormattedStrings(String[] params) {
      String[] formattedStringsArray = new String[params.length];
      for (int i = 0; i < params.length; i++) {
        String[] parameter = params[i].split(",");
        String formattedString = String.format("Студент %s получил %s по предмету %s.", parameter[0], parameter[1], parameter[2]);
        formattedStringsArray[i] = formattedString;
      }
      return formattedStringsArray;
    }
  
    public static void printArray(String[] formattedArray) {
      for (String s :
              formattedArray) {
        System.out.println(s);
      }
    }
  }