CREATE TABLE IF NOT EXISTS projekt (
  id integer primary key,
  name varchar(255)
);

CREATE TABLE IF NOT EXISTS projekt_beschreibung (
    projekt integer primary key references projekt(id),
    beschreibung varchar(255)
);

CREATE TABLE IF NOT EXISTS zeitraum (
    projekt integer primary key references projekt(id),
    von date,
    bis date
);

CREATE TABLE IF NOT EXISTS person (
    id serial primary key,
    projekt integer references projekt(id),
    name varchar(255)
);

