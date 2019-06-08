FROM mhart/alpine-node:12.4.0

WORKDIR /app

COPY . .

RUN npm install

WORKDIR /app

RUN yarn global add serve

WORKDIR /app

RUN npm run build

WORKDIR /app

CMD ["serve", "-p", "80", "-s", "."]
