INSERT INTO product (name, description, price, img_url, category)
SELECT 'Vestido alcinhas',
       'Vestido longo branco com caimento fluido, ideal para eventos especiais.',
       384.90, 'imagens/produto/vestido-1.jpg', 'VESTIDOS'
WHERE NOT EXISTS (
    SELECT 1 FROM product WHERE img_url = 'imagens/produto/vestido-1.jpg'
);

INSERT INTO product (name, description, price, img_url, category)
SELECT 'Vestido longo',
       'Vestido longo elegante com visual moderno para diferentes ocasiões.',
       595.90, 'imagens/produto/vestido-2.jpg', 'VESTIDOS'
WHERE NOT EXISTS (
    SELECT 1 FROM product WHERE img_url = 'imagens/produto/vestido-2.jpg'
);

INSERT INTO product (name, description, price, img_url, category)
SELECT 'Vestido frente único',
       'Vestido frente único com caimento delicado e acabamento sofisticado.',
       469.90, 'imagens/produto/vestido-3.jpg', 'VESTIDOS'
WHERE NOT EXISTS (
    SELECT 1 FROM product WHERE img_url = 'imagens/produto/vestido-3.jpg'
);

INSERT INTO product (name, description, price, img_url, category)
SELECT 'Vestido brilhoso',
       'Vestido com brilho discreto e modelagem moderna para eventos especiais.',
       469.90, 'imagens/produto/vestido-4.jpg', 'VESTIDOS'
WHERE NOT EXISTS (
    SELECT 1 FROM product WHERE img_url = 'imagens/produto/vestido-4.jpg'
);

INSERT INTO product (name, description, price, img_url, category)
SELECT 'Conjunto vinho elegante',
       'Conjunto em tom vinho que combina sofisticação, personalidade e praticidade.',
       319.90, 'imagens/produto/conjunto-1.jpg', 'CONJUNTOS_FEMININOS'
WHERE NOT EXISTS (
    SELECT 1 FROM product WHERE img_url = 'imagens/produto/conjunto-1.jpg'
);

INSERT INTO product (name, description, price, img_url, category)
SELECT 'Conjunto com capa',
       'Conjunto moderno com capa, perfeito para criar uma composição marcante.',
       267.90, 'imagens/produto/conjunto-2.jpg', 'CONJUNTOS_FEMININOS'
WHERE NOT EXISTS (
    SELECT 1 FROM product WHERE img_url = 'imagens/produto/conjunto-2.jpg'
);

INSERT INTO product (name, description, price, img_url, category)
SELECT 'Conjunto manga longa',
       'Conjunto de manga longa com visual clean e confortável.',
       315.00, 'imagens/produto/conjunto-3.jpg', 'CONJUNTOS_FEMININOS'
WHERE NOT EXISTS (
    SELECT 1 FROM product WHERE img_url = 'imagens/produto/conjunto-3.jpg'
);

INSERT INTO product (name, description, price, img_url, category)
SELECT 'Conjunto casual',
       'Conjunto casual em tons neutros, versátil para o dia a dia.',
       187.60, 'imagens/produto/conjunto-4.jpg', 'CONJUNTOS_FEMININOS'
WHERE NOT EXISTS (
    SELECT 1 FROM product WHERE img_url = 'imagens/produto/conjunto-4.jpg'
);

INSERT INTO product (name, description, price, img_url, category)
SELECT 'Camisa em linho',
       'Camisa de linho leve e versátil para produções casuais ou alinhadas.',
       186.90, 'imagens/produto/camisa-1.png', 'CAMISAS_MASCULINAS'
WHERE NOT EXISTS (
    SELECT 1 FROM product WHERE img_url = 'imagens/produto/camisa-1.png'
);

INSERT INTO product (name, description, price, img_url, category)
SELECT 'Camiseta oversized',
       'Camiseta oversized confortável com visual urbano e contemporâneo.',
       145.50, 'imagens/produto/camisa-2.jpg', 'CAMISAS_MASCULINAS'
WHERE NOT EXISTS (
    SELECT 1 FROM product WHERE img_url = 'imagens/produto/camisa-2.jpg'
);

INSERT INTO product (name, description, price, img_url, category)
SELECT 'Camisa em tecido',
       'Camisa de tecido com corte moderno para combinações versáteis.',
       276.85, 'imagens/produto/camisa-4.jpg', 'CAMISAS_MASCULINAS'
WHERE NOT EXISTS (
    SELECT 1 FROM product WHERE img_url = 'imagens/produto/camisa-4.jpg'
);

INSERT INTO product (name, description, price, img_url, category)
SELECT 'Camisa jeans',
       'Camisa jeans casual e resistente para composições descontraídas.',
       276.85, 'imagens/produto/camisa-5.jpg', 'CAMISAS_MASCULINAS'
WHERE NOT EXISTS (
    SELECT 1 FROM product WHERE img_url = 'imagens/produto/camisa-5.jpg'
);

INSERT IGNORE INTO product_available_sizes (product_id, size)
SELECT p.id, sizes.size
FROM product p
JOIN (
    SELECT 'PP' AS size
    UNION ALL SELECT 'P'
    UNION ALL SELECT 'M'
    UNION ALL SELECT 'G'
    UNION ALL SELECT 'GG'
) sizes
WHERE p.img_url IN (
    'imagens/produto/vestido-1.jpg',
    'imagens/produto/vestido-2.jpg',
    'imagens/produto/vestido-3.jpg',
    'imagens/produto/vestido-4.jpg',
    'imagens/produto/conjunto-1.jpg',
    'imagens/produto/conjunto-2.jpg',
    'imagens/produto/conjunto-3.jpg',
    'imagens/produto/conjunto-4.jpg',
    'imagens/produto/camisa-1.png',
    'imagens/produto/camisa-2.jpg',
    'imagens/produto/camisa-4.jpg',
    'imagens/produto/camisa-5.jpg'
);
