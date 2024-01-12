select * from employees
insert into  employees (employee_id, first_name, last_name, department_id, hospital_id) values (1, 'John', 'Doe', 1, 1), (2, 'Jane', 'Smith', 1, 1), (3, 'Mike', 'Johnson', 2, 1), (4, 'emma', 'Williams', 2, 1), (5, 'Chris', 'Anderson', 3, 1)


select * from hospitals
insert into  hospitals (id, hospital_name)values (1, 'uchealt Hospital'), (2, 'Denver Hospital')


insert into departments(department_id, department_name) values (1 , 'DR'), (2, 'NURSE'), (3, 'ADMIN')
select * from departments

select * from salaries
insert into salaries(employee_id, salary)values (1, 90000.0), (2, 80000.0), (3, 60000.0), (4, 55000.0), (5, 100000.0)


select * from patients
insert into patients(patient_id, first_name, last_name, hospitat_id)values
(1, 'Evelyn', 'Rodriguez', 1),
(2, 'Liam', 'Patel', 1),
(3, 'Isabella', 'Nguyen', 1),
(4, 'Elijah', 'Sullivan', 1),
(5, 'Mia', 'Kim', 1)

select * from billings
insert into billings(bill_number, bill_details, amount, patient_id)values (1, 'for the last visit', 42.75, 1), (2, 'for the last visit', 159.99, 2), (3, 'for the last visit', 73.50, 3), (4, 'for the last visit', 8.25, 4), (5, 'for the last visit', 224.60, 5)


select * from appointments
insert into appointments(id, appointment_details, patient_id) values
(1, 'Cardiology', 1),
(2, 'Orthopedic', 2),
(3, 'Dermatology', 3),
(4, 'Gastroenterology', 4),
(5, 'Ophthalmology', 5)

select * from laboratory_tests
insert into laboratory_tests(id, test_details, patient_id) values
(1, 'Lipid Panel', 1),
(2, 'Urinalysis', 2),
(3, 'Complete Blood Count', 3),
(4, 'Thyroid Function', 4),
(5, 'Liver Function', 5)

select * from medications
insert into medications(id, medication_name, medication_details, patient_id) values
(1, 'Tranquilix', 'Follow Instructions', 1),
(2, 'CardioGuard', 'Take with Water', 2),
(3, 'PainRelief', 'Timing Matters', 3),
(4, 'RespiraCare', 'Dont Skip Doses', 4),
(5, 'NeuroCalm', 'Inform Your Doctor', 5)

select * from rooms
insert into rooms(room_number, patient_id) values (12, 1), (23, 2), (34, 3), (45, 4), (56, 5)


INSERT INTO billings (amount)
VALUES
  (42.75),
  (159.99),
  (73.50),
  (8.25),
  (224.60);

select * from billings
insert into billings(bill_number, bill_details, amount, patient_id) values (6, 'for the last visit', 42.75, 5)

select * from appointments
select employee_id, first_name, last_name, department_id, hospital_id from employees where employee_id = 1
select * from appointments where id = 1

