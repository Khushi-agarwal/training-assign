-----------------------------------------------------------------
1st part of assignment
------------------------------------------------------------------


mysql> create table department(dept_no int,dept_name text,dept_location text,primary key(dept_no));
Query OK, 0 rows affected (0.02 sec)

mysql> desc department;
+---------------+------+------+-----+---------+-------+
| Field         | Type | Null | Key | Default | Extra |
+---------------+------+------+-----+---------+-------+
| dept_no       | int  | NO   | PRI | NULL    |       |
| dept_name     | text | YES  |     | NULL    |       |
| dept_location | text | YES  |     | NULL    |       |
+---------------+------+------+-----+---------+-------+
3 rows in set (0.01 sec)

mysql> create table employee(emp_no int,emp_name text,emp_age int,check(emp_age>=18),emp_gender char(1),check(emp_gender in ('M','F')),dept_no int, primary key(emp_no),foreign key(dept_no) references department(dept_no)on delete cascade);
Query OK, 0 rows affected (0.03 sec)

mysql> desc employee;
+------------+---------+------+-----+---------+-------+
| Field      | Type    | Null | Key | Default | Extra |
+------------+---------+------+-----+---------+-------+
| emp_no     | int     | NO   | PRI | NULL    |       |
| emp_name   | text    | YES  |     | NULL    |       |
| emp_age    | int     | YES  |     | NULL    |       |
| emp_gender | char(1) | YES  |     | NULL    |       |
| dept_no    | int     | YES  | MUL | NULL    |       |
+------------+---------+------+-----+---------+-------+
5 rows in set (0.01 sec)

mysql> insert into department values(101,'CS','LKO');
Query OK, 1 row affected (0.00 sec)

mysql> insert into employee values(101,'Atul',19,'k',1);
ERROR 3819 (HY000): Check constraint 'employee_chk_2' is violated.

mysql> insert into employee values(11,'Atul',19,'M',101);
Query OK, 1 row affected (0.00 sec)

mysql> select * from employee;
+--------+----------+---------+------------+---------+
| emp_no | emp_name | emp_age | emp_gender | dept_no |
+--------+----------+---------+------------+---------+
|     11 | Atul     |      19 | M          |     101 |
+--------+----------+---------+------------+---------+
1 row in set (0.01 sec)

mysql> select * from department
    -> ;
+---------+-----------+---------------+
| dept_no | dept_name | dept_location |
+---------+-----------+---------------+
|     101 | CS        | LKO           |
+---------+-----------+---------------+
1 row in set (0.00 sec)



------------------------------------------------------------

2nd part of the assignment
-------------------------------------------------------------

mysql> create table Course(course_id int,course_name text);
Query OK, 0 rows affected (0.02 sec)

mysql> insert into Course values(122,'Maths');
Query OK, 1 row affected (0.01 sec)

mysql> insert into Course values(123,'English');
Query OK, 1 row affected (0.00 sec)

mysql> desc Course;
+-------------+------+------+-----+---------+-------+
| Field       | Type | Null | Key | Default | Extra |
+-------------+------+------+-----+---------+-------+
| course_id   | int  | YES  |     | NULL    |       |
| course_name | text | YES  |     | NULL    |       |
+-------------+------+------+-----+---------+-------+
2 rows in set (0.00 sec)

mysql>create table Course_copy like  Course;
mysql> desc Course_copy;
+-------------+------+------+-----+---------+-------+
| Field       | Type | Null | Key | Default | Extra |
+-------------+------+------+-----+---------+-------+
| course_id   | int  | YES  |     | NULL    |       |
| course_name | text | YES  |     | NULL    |       |
+-------------+------+------+-----+---------+-------+
2 rows in set (0.00 sec)

mysql> alter table Course add(course_teach text, course_time date);
Query OK, 0 rows affected (0.01 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> desc Course;
+--------------+------+------+-----+---------+-------+
| Field        | Type | Null | Key | Default | Extra |
+--------------+------+------+-----+---------+-------+
| course_id    | int  | YES  |     | NULL    |       |
| course_name  | text | YES  |     | NULL    |       |
| course_teach | text | YES  |     | NULL    |       |
| course_time  | date | YES  |     | NULL    |       |
+--------------+------+------+-----+---------+-------+
4 rows in set (0.00 sec)


mysql> select * from Course;
+-----------+-------------+--------------+-------------+
| course_id | course_name | course_teach | course_time |
+-----------+-------------+--------------+-------------+
|       122 | Maths       | NULL         | NULL        |
|       123 | English     | NULL         | NULL        |
+-----------+-------------+--------------+-------------+
2 rows in set (0.00 sec)

mysql> alter table Course drop column course_teach,drop column course_time;
Query OK, 0 rows affected (0.02 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> desc Course;
+-------------+------+------+-----+---------+-------+
| Field       | Type | Null | Key | Default | Extra |
+-------------+------+------+-----+---------+-------+
| course_id   | int  | YES  |     | NULL    |       |
| course_name | text | YES  |     | NULL    |       |
+-------------+------+------+-----+---------+-------+
2 rows in set (0.01 sec)

mysql> alter table Course rename column course_name to name;
Query OK, 0 rows affected (0.01 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> desc Course;
+-----------+------+------+-----+---------+-------+
| Field     | Type | Null | Key | Default | Extra |
+-----------+------+------+-----+---------+-------+
| course_id | int  | YES  |     | NULL    |       |
| name      | text | YES  |     | NULL    |       |
+-----------+------+------+-----+---------+-------+
2 rows in set (0.01 sec)

mysql> select * from Course;
+-----------+---------+
| course_id | name    |
+-----------+---------+
|       122 | Maths   |
|       123 | English |
+-----------+---------+
2 rows in set (0.00 sec)


