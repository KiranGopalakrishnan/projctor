FROM mhart/alpine-node:11 AS builder
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build

FROM nginx
RUN mkdir /app
WORKDIR /app
COPY --from=builder /app/static /app
COPY nginx.conf /etc/nginx/nginx.conf