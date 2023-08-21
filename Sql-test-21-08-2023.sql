
select emp_no,emp_name,emp_sal,d.deptno,dept_name,dept_manager,city,state  from dept d join address on d.address_id=address.address_id join employee on  d.deptno=employee.deptno;

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

 create table bankacc(acc_no int primary key,acc_opened_date date,status text,balance int);

 create table transaction(acc_no int,trans_type char,trans_date date,trans_amount double,foreign key(acc_no) references bankacc(acc_no) on delete cascade);

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
 select manager_name,sum(emp_sal) from emp group by manager_name;
+--------------+--------------+
| manager_name | sum(emp_sal) |
+--------------+--------------+
| ABC          |         3000 |
| DEF          |         6400 |
+--------------+--------------+

select emp_sal from emp ORDER BY emp_sal DESC limit 4,1;
+---------+
| emp_sal |
+---------+
|     400 |
+---------+

