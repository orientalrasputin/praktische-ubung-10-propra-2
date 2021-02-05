CREATE TABLE IF NOT EXISTS projekt (
  id integer primary key,
  name varchar
);

CREATE TABLE IF NOT EXISTS projekt_beschreibung (
    projekt integer primary key references projekt(id),
    beschreibung varchar
);

CREATE TABLE IF NOT EXISTS zeitraum (
    projekt integer primary key references projekt(id),
    von date,
    bis date
);


