#!/bin/bash
set -e

# 不要覆蓋 PATH（你原本那行會把 Java 路徑踢掉，導致 java not found）
export PATH=".:/usr/local/bin:/usr/bin:/bin:/usr/games:${PATH}"

: "${DB_HOST:?DB_HOST is required}"
: "${DB_PWD:?DB_PWD is required}"

# 1) 關掉 client 端 SSL 要求（避免 ERROR 2026）
# MYSQL=(mysql --ssl-mode=DISABLED -h "${DB_HOST}" -u root -p"${DB_PWD}")
MYSQL=(/usr/bin/mariadb --ssl=0 -h "${DB_HOST}" -u root -p"${DB_PWD}")

# 2) 修 line 9：用 grep -q 避免空字串造成 unary operator expected
if echo "SHOW DATABASES;" | "${MYSQL[@]}" | grep -q "^l1jdb380$"; then
  echo "Database l1jdb380 exist!"
else
  echo "create database l1jdb380;" | "${MYSQL[@]}"
  "${MYSQL[@]}" l1jdb380 < /data/db/l1jdb_Taiwan.sql
fi

cd /data/config/

sed 's/mysql:\/\/localhost/mysql:\/\/'"$DB_HOST"'/g' server.properties > custom.server; cat custom.server > server.properties
sed 's/Password=password/Password='"$DB_PWD"'/g' server.properties > custom.server; cat custom.server > server.properties

sed 's/RateXp = 1.0/RateXp = '"$RATE_XP"'/g' rates.properties > custom.rates; cat custom.rates > rates.properties
sed 's/RateLawful = 1.0/RateLawful = '"$RATE_LAWFUL"'/g' rates.properties > custom.rates; cat custom.rates > rates.properties
sed 's/RateKarma = 1.0/RateKarma = '"$RATE_KARMA"'/g' rates.properties > custom.rates; cat custom.rates > rates.properties
sed 's/RateDropAdena = 1.0/RateDropAdena = '"$RATE_DROP_GOLD"'/g' rates.properties > custom.rates; cat custom.rates > rates.properties
sed 's/RateDropItems = 1.0/RateDropItems = '"$RATE_DROP_ITEM"'/g' rates.properties > custom.rates; cat custom.rates > rates.properties

sed 's/EnchantChanceWeapon = 0/EnchantChanceWeapon = '"$ENCHANT_CHANCE"'/g' rates.properties > custom.rates; cat custom.rates > rates.properties
sed 's/EnchantChanceArmor = 0/EnchantChanceArmor = '"$ENCHANT_CHANCE"'/g' rates.properties > custom.rates; cat custom.rates > rates.properties
sed 's/AttrEnchantChance = 10/AttrEnchantChance = '"$ENCHANT_CHANCE"'/g' rates.properties > custom.rates; cat custom.rates > rates.properties

cd /data

java -Xmx512m -Xincgc -jar /data/l1jserver.jar
