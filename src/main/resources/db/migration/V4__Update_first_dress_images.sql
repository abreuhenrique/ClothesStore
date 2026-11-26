-- Give the first two dress products distinct images from the existing catalog.
UPDATE product
SET img_url = 'imagens/produto/vestido-branco-novo.jpg'
WHERE category = 'VESTIDOS'
  AND LOWER(TRIM(name)) IN ('vestido longo branco', 'vestido longo branco.', 'vestido alcinhas');

UPDATE product
SET img_url = 'imagens/produto/vestido-5.jpg'
WHERE category = 'VESTIDOS'
  AND LOWER(TRIM(name)) IN ('vestido vermelho', 'vestido longo');
