FROM mhart/alpine-node:11 AS builder
WORKDIR /app
COPY . .
RUN npm run build

FROM mhart/alpine-node
RUN npm install server -g
WORKDIR /app
COPY --from=builder /app/static .
CMD ["serve","-p","80","-s","."]