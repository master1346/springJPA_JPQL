select product_name from ORDERS where customer_id = (select id from CUSTOMERS where name = ?);
