create table student_fee (
	student_id INT,
    fee_name varchar(20),
    periodicity varchar(20),
    fine_applicable boolean,
    concession_applicable boolean,
    payment_priority int,
    account_heads varchar(10),
    primary key (student_id)
);