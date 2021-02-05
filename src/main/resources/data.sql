INSERT INTO projekt (id, name)
VALUES (1, 'projekt 1');

INSERT INTO projekt_beschreibung (projekt, beschreibung)
VALUES (1, 'bubiba');

INSERT INTO zeitraum (projekt, von, bis)
VALUES (1, NOW(), NOW());

INSERT INTO person (id, projekt, name)
VALUES (1, 1, 'Jurij');