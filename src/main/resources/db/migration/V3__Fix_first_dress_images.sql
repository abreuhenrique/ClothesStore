UPDATE product
SET img_url = 'imagens/produto/vestido-1.jpg'
WHERE category = 'VESTIDOS'
  AND LOWER(TRIM(name)) IN ('vestido longo branco', 'vestido longo branco.', 'vestido alcinhas');

UPDATE product
SET img_url = 'imagens/produto/vestido-2.jpg'
WHERE category = 'VESTIDOS'
  AND LOWER(TRIM(name)) IN ('vestido vermelho', 'vestido longo');
