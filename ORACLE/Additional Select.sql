--1 
SELECT STUDENT_NO "학번", STUDENT_NAME "이름", ENTRANCE_DATE "입학년도" FROM TB_STUDENT WHERE DEPARTMENT_NO = '002' ORDER BY ENTRANCE_DATE;

--2
SELECT PROFESSOR_NAME, PROFESSOR_SSN FROM TB_PROFESSOR WHERE LENGTH(PROFESSOR_NAME)!= 3;

--3
SELECT PROFESSOR_NAME"교수이름", 2023-LPAD(SUBSTR(PROFESSOR_SSN, 1, 2), 4, 19)"나이" FROM TB_PROFESSOR WHERE SUBSTR(PROFESSOR_SSN, 8, 1) = 1;

--4
SELECT SUBSTR(PROFESSOR_NAME, 2, 2) FROM TB_PROFESSOR;

--5 
SELECT STUDENT_NO, STUDENT_NAME FROM TB_STUDENT WHERE EXTRACT(YEAR FROM ENTRANCE_DATE) - LPAD(SUBSTR(STUDENT_SSN, 1, 2), 4, '19') > 19;
 
--6
SELECT TO_CHAR(TO_DATE('20201225', 'YYYYMMDD'), 'DAY') FROM DUAL;

--7
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';
SELECT TO_DATE('99/10/11', 'YY/MM/DD')"값1", TO_DATE('49/10/11', 'YY/MM/DD')"값2", TO_DATE('99/10/11', 'RR/MM/DD')"값3", TO_DATE('49/10/11', 'RR/MM/DD')"값4" FROM DUAL;

--8
SELECT STUDENT_NO, STUDENT_NAME FROM TB_STUDENT WHERE SUBSTR(STUDENT_NO, 1, 1) != 'A'; 

--9
SELECT ROUND(AVG(POINT),1)"평점" FROM TB_GRADE WHERE STUDENT_NO = 'A517178';

-- 10
SELECT DEPARTMENT_NO 학과번호, COUNT(*) "학생수(명)" FROM TB_STUDENT 
GROUP BY DEPARTMENT_NO ORDER BY 1;

--11
SELECT COUNT(*) FROM TB_STUDENT WHERE COACH_PROFESSOR_NO IS NULL;

--12
SELECT DISTINCT SUBSTR(TERM_NO, 1, 4)"년도", ROUND(AVG(POINT),1)"년도 별 평점" 
FROM TB_GRADE 
WHERE STUDENT_NO = 'A112113' 
GROUP BY SUBSTR(TERM_NO, 1, 4) 
ORDER BY 1;

--13
SELECT DEPARTMENT_NO 학과코드명, COUNT(DECODE(ABSENCE_YN, 'Y', 'Y')) "휴학생 수" 
FROM TB_STUDENT 
GROUP BY DEPARTMENT_NO 
ORDER BY 1;

--14
SELECT STUDENT_NAME"동일이름", COUNT(*)"동명인 수"
FROM TB_STUDENT
GROUP BY STUDENT_NAME
HAVING COUNT(STUDENT_NAME) > 1
ORDER BY 1;

--15
SELECT SUBSTR(TERM_NO,1,4)"년도", AVG(POINT)"평균"
FROM TB_GRADE 
WHERE STUDENT_NO = 'A112113'
GROUP BY TERM_NO
ORDER BY 1;


select * from tb_class;
SELECT * FROM TB_CLASS_PROFESSOR;
SELECT * FROM TB_DEPARTMENT;
SELECT * FROM TB_GRADE;
SELECT * FROM TB_PROFESSOR;
SELECT * FROM TB_STUDENT;