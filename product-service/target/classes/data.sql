INSERT INTO category (id, name)
values (1, 'shoes');
INSERT INTO category (id, name)
values (2, 'books');

insert into product (id, name, description, stock, price, status, created_at, category_id)
    values
    (2, 'nike 100', 'nike shoes', 100, 150,'active', now(), 1);

insert into product (id, name, description, stock, price, status, created_at, category_id)
    values
    (3, 'Harry Potter', 'Harry potter 1', 1000, 40,'active', now(), 2);