ALTER TABLE products
ADD COLUMN Created_at TIMESTAMP AFTER Price;

ALTER TABLE products
ADD COLUMN Modified_at TIMESTAMP AFTER Created_at;