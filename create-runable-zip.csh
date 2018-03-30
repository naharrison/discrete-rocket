#!/bin/csh -f

rm -rf rocket-app rocket-app.zip

mvn install
mvn clean compile assembly:single
mkdir rocket-app
cp target/phys2211-1.0-SNAPSHOT-jar-with-dependencies.jar rocket-app
chmod +x rocket-app/phys2211-1.0-SNAPSHOT-jar-with-dependencies.jar
mv rocket-app/phys2211-1.0-SNAPSHOT-jar-with-dependencies.jar rocket-app/rocket.jar
cp -r data rocket-app
zip -r rocket-app.zip rocket-app
rm -rf rocket-app
