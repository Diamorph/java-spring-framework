select * from product;

DELIMITER //

CREATE PROCEDURE GetAllProducts()
BEGIN
	SELECT * FROM product;
END;

DELIMITER ;


DELIMITER //

create procedure GetAllProductsByPrice(in price_in decimal)
begin
	select * from product where price>price_in;
end;

DELIMITER ;

DELIMITER //

create procedure GetAllProductsCountByPrice(in price_in decimal)
begin
	select count(*) from product where price>price_in;
end;

DELIMITER ;

drop procedure GetAllProducts;
drop procedure GetAllProductsByPrice;
drop procedure GetAllProductsCountByPrice;