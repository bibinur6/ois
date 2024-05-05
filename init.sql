CREATE TABLE IF NOT EXISTS product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    price DOUBLE PRECISION NOT NULL DEFAULT 0,
    quantity INT NOT NULL DEFAULT 1,
    description TEXT DEFAULT NULL
);

INSERT INTO product(name, price, quantity, description) 
VALUES ('Milk', 2.99, 10, '1 Gallon'),
       ('Bread', 1.99, 20, 'Whole Wheat'),
       ('Chocolate', 3.49, 15, 'Dark Chocolate Bar'),
       ('Ice Cream', 4.99, 8, 'Vanilla Flavor'),
       ('Eggs', 2.49, 30, 'Large Grade A'),
       ('Apples', 0.79, 50, 'Red Delicious'),
       ('Orange Juice', 3.29, 12, '100% Pure Squeezed'),
       ('Potatoes', 1.29, 40, 'Russet'),
       ('Chicken Breast', 5.99, 25, 'Boneless Skinless'),
       ('Pasta', 1.49, 18, 'Spaghetti'),
       ('Salmon', 8.99, 10, 'Wild Caught Alaskan'),
       ('Yogurt', 2.79, 15, 'Greek Style Plain'),
       ('Cereal', 3.99, 22, 'Whole Grain Oats'),
       ('Coffee', 7.49, 28, 'Medium Roast');


