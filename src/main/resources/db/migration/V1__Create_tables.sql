CREATE TABLE product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(120) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    img_url VARCHAR(255),
    category VARCHAR(30) NOT NULL,
    CONSTRAINT ck_product_category
        CHECK (category IN ('VESTIDOS', 'CONJUNTOS_FEMININOS', 'CAMISAS_MASCULINAS'))
);

CREATE TABLE product_available_sizes (
    product_id BIGINT NOT NULL,
    size VARCHAR(2) NOT NULL,
    PRIMARY KEY (product_id, size),
    CONSTRAINT fk_product_available_sizes_product
        FOREIGN KEY (product_id) REFERENCES product (id),
    CONSTRAINT ck_product_available_sizes_size
        CHECK (size IN ('PP', 'P', 'M', 'G', 'GG'))
);

CREATE TABLE orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_number BIGINT NOT NULL UNIQUE,
    customer_name VARCHAR(120) NOT NULL,
    customer_email VARCHAR(120) NOT NULL,
    customer_phone VARCHAR(20) NOT NULL,
    cep VARCHAR(9) NOT NULL,
    street VARCHAR(120) NOT NULL,
    number VARCHAR(20) NOT NULL,
    complement VARCHAR(120),
    district VARCHAR(120) NOT NULL,
    city VARCHAR(120) NOT NULL,
    state VARCHAR(2) NOT NULL,
    order_status VARCHAR(20) NOT NULL,
    created_at DATETIME NOT NULL,
    subtotal DECIMAL(10, 2) NOT NULL,
    shipping_cost DECIMAL(10, 2) NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    CONSTRAINT ck_orders_status
        CHECK (order_status IN ('CREATED', 'CONFIRMED', 'PREPARING', 'SHIPPED', 'DELIVERED', 'CANCELLED'))
);

CREATE TABLE order_item (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    product_name VARCHAR(120) NOT NULL,
    selected_size VARCHAR(2) NOT NULL,
    unit_price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    subtotal DECIMAL(10, 2) NOT NULL,
    CONSTRAINT fk_order_item_orders
        FOREIGN KEY (order_id) REFERENCES orders (id),
    CONSTRAINT ck_order_item_selected_size
        CHECK (selected_size IN ('PP', 'P', 'M', 'G', 'GG')),
    CONSTRAINT ck_order_item_quantity
        CHECK (quantity > 0)
);
