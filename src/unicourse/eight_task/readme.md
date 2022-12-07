1. Ссылка для установки сервера MySQL `https://dev.mysql.com/downloads/mysql/`<br>
   a. Скачать и установить сервер БД (MySql Installer)<br>
   b. Создать новое соединение, запомнить username & password<br>
   c. Создать новую схему и соответствующие таблицы<br>
2. Драйвер для MySQL `https://mvnrepository.com/artifact/mysql/mysql-connector-java`
   a. Скачать драйвер и добавить его в проект<br>
3. Установить соединение с БД в IntelliJ IDEA<br>
   a. Если нет плагина Database Navigator, то установить его<br>
   b. При создании нового соединения в Database Navigator’е – выбрать «custom»<br>
   c. Добавить информацию в соответствующие поля<br>
   d. В строке url - добавить параметр serverTimezone (для установления корректного
   соеднинения):
   `jdbc:mysql://localhost:3306/mysql?serverTimezone=UTC`<br>
   e. Проверить, что соединение установлено<br>
4. В проекте:
   a. Импортировать библиотеку import java.sql.*;<br>
   b. Установить соединение:<br>
   ```java
   try {
   Connection сon = DriverManager.getConnection("jdbc:mysql://localhost:3306/products", "root",
   "password");
   }
   catch (SQLException e){
   e.printStackTrace();
   }
   c. Пример обработки запроса «select»
   Statement st = con.createStatement();
   String s= "select * from product"; // строка запроса
   ResultSet res =st.executeQuery(s); // выполнение запроса
   while(res.next()){ // вывод результатов
   System.out.println(res.getString ("name")+" "+ res.getInt ("price"));
   }
   con.close();
   ```
<h3>Задание</h3>
8.1. Создать класс «категории товаров» и класс «товары». Создать приложение, которое:<br>
- содержит коллекцию товаров
- добавляет, удаляет товары и категории товаров
- позволяет выбирать товары нужной категории
- позволяет фильтровать данные
- выводит общую стоимость всех товаров, выбранной категории

8.2. Добавить возможность визуализации данные:
- отобразить распределение количества товаров по категориям
- отобразить самые высокие цены каждой категории
- отобразить цены товаров выбранной категории