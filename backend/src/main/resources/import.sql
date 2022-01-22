insert into
    hotel_room(maxpeople, pricepernight, roomnumber)
VALUES (4,250,6);

insert into role(role) values ('admin');
insert into role(role) values ('user');

insert into
    hotel_customer(name, pw)
VALUES ('Ben','123');

insert into role_hotel_customer(roles_id, users_id) values (1,1);

insert into
    hotel_booking(arrivaldate, bookingdate, departuredate, customer_id, room_id)
VALUES (to_date('2022-01-01', 'YYYY-MM-DD'), to_date('2022-01-01', 'YYYY-MM-DD'), to_date('2022-01-01', 'YYYY-MM-DD'), 1, 1);

