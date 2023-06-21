--1.

SELECT department_name AS "학과명", CATEGORY AS "계열" FROM tb_department;

--2.
SELECT department_name || '의 정원은 ' || CAPACITY || '명 입니다.' AS "학과별 정원" FROM tb_department;

--3.
SELECT student_name FROM tb_student WHERE department_no = 001 AND student_ssn LIKE '_______2%' AND absence_yn LIKE '%Y%' ; 

--4.
SELECT student_name FROM tb_student WHERE student_no IN ('A513079', 'A513090', 'A513091', 'A513110', 'A513119') ORDER BY student_no DESC;

--5.
SELECT department_name, CATEGORY FROM tb_department WHERE CAPACITY BETWEEN 20 AND 30;

--6.
SELECT professor_name FROM tb_professor WHERE department_no IS NULL;

--7.
SELECT student_name FROM tb_student WHERE department_no IS NULL;

--8.
SELECT class_no, class_name FROM tb_class WHERE class_no IN ('C0405500', 'C0409000', 'C3745400', 'C0432500', 'C3051900', 'C3221500');

--9.
SELECT DISTINCT CATEGORY FROM tb_department;

--10.
SELECT student_no, student_name, student_ssn FROM tb_student WHERE entrance_date BETWEEN '02/01/01' AND '02/12/31' AND absence_yn LIKE '%N%' AND student_address LIKE '%전주%';

