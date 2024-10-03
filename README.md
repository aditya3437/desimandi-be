http://localhost:8080/swagger-ui.html

## add product
curl --location 'http://localhost:8080/desimandi/product' \
--header 'Content-Type: application/json' \
--data '{
"productName": "Lady finger",
"buyPrice": 14,
"price": 28,
"imageUrl": "https://example.com/image.jpg"
}'

## Fetch Products
curl --location 'http://localhost:8080/desimandi/products'