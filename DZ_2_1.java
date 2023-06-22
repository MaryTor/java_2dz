//Дана строка sql-запроса "select * from students where ".
// Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
//Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
public class Task1 {
    public static void main(String[] args) {
        StringBuilder sqlQuery = new StringBuilder("select * from students where");
        String filterParams = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        sqlQuery.append(getWhereClause(filterParams));
        System.out.println(sqlQuery);
    }
    public static String getWhereClause(String jsonObject) {
        jsonObject = jsonObject.replace("\"", "");
        jsonObject = jsonObject.replace("{", "");
        jsonObject = jsonObject.replace("}", "");
        String[] filterArray = jsonObject.split(", ");
        StringBuilder whereClause = new StringBuilder();
        for (String param:
                filterArray) {
            String[] paramArray = param.split(":");
            if (paramArray[1].equals("null")){
                continue;
            }
            String addedParam = String.format(" and %s = '%s'", paramArray[0], paramArray[1]);
            whereClause.append(addedParam);
        }
        whereClause.delete(0, 4);
        return whereClause.toString();
    }
}