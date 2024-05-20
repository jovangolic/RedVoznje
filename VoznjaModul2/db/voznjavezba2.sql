DROP SCHEMA IF EXISTS voznjavezba2;
CREATE SCHEMA voznjavezba2 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE voznjavezba2;

CREATE TABLE linije (
	id bigint AUTO_INCREMENT, 
	redni_broj INT NOT NULL, 
	polaziste VARCHAR(50) NOT NULL, 
	odrediste VARCHAR(50) NOT NULL, 
	gradski BOOLEAN NOT NULL, 
	PRIMARY KEY(id)
);

CREATE TABLE voznje (
	id BIGINT AUTO_INCREMENT, 
	linijaId bigint NOT NULL, 
    smer ENUM('A', 'B') DEFAULT 'A', 
	polazak TIME NOT NULL, 
	PRIMARY KEY(id), 
	FOREIGN KEY(linijaId) REFERENCES linije(id)
		ON DELETE RESTRICT
);

INSERT INTO linije (id, redni_broj, polaziste, odrediste, gradski) VALUES (1, 1, 'Klisa', 'Liman 1', true);
INSERT INTO linije (id, redni_broj, polaziste, odrediste, gradski) VALUES (2, 2, 'Centar', 'Novo naselje', true);
INSERT INTO linije (id, redni_broj, polaziste, odrediste, gradski) VALUES (3, 21, 'Centar', 'Šangaj', false);

INSERT INTO voznje (id,linijaId, smer, polazak) VALUES (1,1, 'A', '08:00');
INSERT INTO voznje (id,linijaId, smer, polazak) VALUES (2,1, 'A', '09:00');
INSERT INTO voznje (id,linijaId, smer, polazak) VALUES (3,1, 'B', '08:10');
INSERT INTO voznje (id,linijaId, smer, polazak) VALUES (4,1, 'B', '09:10');
INSERT INTO voznje (id,linijaId, smer, polazak) VALUES (5,2, 'A', '08:05');
INSERT INTO voznje (id,linijaId, smer, polazak) VALUES (6,2, 'A', '09:05');
INSERT INTO voznje (id,linijaId, smer, polazak) VALUES (7,2, 'B', '08:15');
INSERT INTO voznje (id,linijaId, smer, polazak) VALUES (8,2, 'B', '09:15');
INSERT INTO voznje (id,linijaId, smer, polazak) VALUES (9,3, 'A', '08:15');
INSERT INTO voznje (id,linijaId, smer, polazak) VALUES (10,3, 'A', '09:15');
INSERT INTO voznje (id,linijaId, smer, polazak) VALUES (11,3, 'B', '08:15');
INSERT INTO voznje (id,linijaId, smer, polazak) VALUES (12,3, 'B', '09:15');