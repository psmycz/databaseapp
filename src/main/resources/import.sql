-- uwaga bo wyjebie sie jak np. przypisze przylacze do nieistniejacej sali np. przylacze(salaId = 8), a nie ma sali o takim id
-- do sprawdzenia

insert into sala (numer, budynek) values (61,'A');
insert into sala (numer, budynek) values (112,'D');
insert into sala (numer, budynek) values (32,'C');
insert into sala (numer, budynek, opis) values (303,'B', 'mała aula');
insert into sala (numer, budynek) values (202,'B');
insert into sala (numer, budynek) values (110,'A');

insert into przylacze (sala_id, nazwa) values (1,'ścienne');
insert into przylacze (sala_id, nazwa, opis) values (3,'MAXBERT','sprawne');
insert into przylacze (sala_id, nazwa) values (6,'MAXBERT,FLOORBOX');

insert into naprawa (sala_id, data_naprawy, opis) values (1,'2012-12-12','wymiana lampy');
insert into naprawa (sala_id, data_naprawy) values (1,SYSDATE());
insert into naprawa (sala_id, data_naprawy, opis) values (4,SYSDATE(),'naprawa rolet');

insert into ekran (sala_id, model, wymiary,sterowanie,opis) values (1,'AVERS','3m','przyciskami żaluzjowo-chwilowymi','4:3');
insert into ekran (sala_id, model, wymiary,sterowanie,opis) values (2,'KRAFTMANN','4m',' przyciskami żaluzjowo-stałymi','4:3');
insert into ekran (sala_id, model, wymiary,sterowanie,opis) values (2,'ADEO','2,75m','ekran niezwijalny','16:10' );

insert into audio (sala_id,typ, opis) values ( 2, 'wzmacniacz','VM-5125 ELEKTRONIKA');
insert into audio (sala_id,typ, opis) values ( 2, 'głośniki','15 sztuk');
insert into audio (sala_id,typ, opis) values ( 1, 'mikrofon','2sztuki');
insert into audio (sala_id,typ, opis) values ( 5, 'mikrofon','');

insert into automatyka (sala_id, nazwa, opis) values ( 1, 'szafka rozdzielcza',NULL);
insert into automatyka (sala_id, nazwa, opis) values ( 1, 'szafa2',NULL);
insert into automatyka (sala_id, nazwa, opis) values ( 2, 'szafa3',NULL);
insert into automatyka (sala_id, nazwa, opis) values ( 1, 'szafa4','opis');

insert into tablica (sala_id,model,wymiary,opis) values (3,'model11','3x5',NULL);
insert into tablica (sala_id,model,wymiary,opis) values (2,'model12','5x5',NULL);
insert into tablica (sala_id,model,wymiary,opis) values (1,'model12','4x5','opis');

insert into visualizer (sala_id, model, opis) values (1,'EPSON', 'ELPDC11');
insert into visualizer (sala_id, model, opis) values (2,'2', NULL);
insert into visualizer (sala_id, model, opis) values (6,'1', 'opis');

insert into wyposazenie (sala_id, rolety, oswietlenie, pilot, inne, opis) values ( 1,'ręczne','oświetlenie tablicy','nie ma','zegar',NULL);
insert into wyposazenie (sala_id, rolety, oswietlenie, pilot, inne, opis) values ( 2,'ręczne naokienne',NULL,NULL,'inny',NULL);
insert into wyposazenie (sala_id, rolety, oswietlenie, pilot, inne, opis) values ( 3,'automatyczne','cztery strefy',NULL,NULL,'ładna sala');

insert into zlacze (sala_id, nazwa, dlugosc, opis) values (1,'usb',5.5,NULL);
insert into zlacze (sala_id, nazwa, dlugosc, opis) values (1,'hdmi',5,NULL);
insert into zlacze (sala_id, nazwa, dlugosc, opis) values (1,'vga',2,'zwykly kabel');

insert into projektor(sala_id,model,numer_seryjny,adres_ip,adres_mac,wersja_oprogr,opis) values (1,'NEC NP-M420XG','2540283UF','brak','ad:ad:ad:ad:ad:ad','1.4.521',NULL);
insert into projektor(sala_id,model,numer_seryjny,adres_ip,adres_mac,wersja_oprogr,opis) values (1,'EPSON EB925','PAWF290210L','1.1.1.2','ad:ad:ad:ad:ad:bd','1.4.521','opis');
insert into projektor(sala_id,model,numer_seryjny,adres_ip,adres_mac,wersja_oprogr,opis) values (2,'EPSON EB-955WH','VSMK6901428','1.1.1.3','ad:ad:ad:ad:ad:cd','1.4.521',NULL);

insert into lampa (projektor_id,czas_pracy,data_kontroli,sprawna,opis) values (1,5555,sysdate(),false,NULL);
insert into lampa (projektor_id,czas_pracy,data_kontroli,sprawna,opis) values (1,24,sysdate(),true,NULL);
insert into lampa (projektor_id,czas_pracy,data_kontroli,sprawna,opis) values (2,0,sysdate(),true,'no dziala');