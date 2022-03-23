insert into tbl_temperature_sensor(id, serial, name) values (1, '1020492578', 'Sensor De Temperatura Ds18b20')
insert into tbl_temperature_sensor(id, serial, name) values (2, '1128546812', 'Sensor Temperatura Y Humedad Dht11')
insert into tbl_temperature_sensor(id, serial, name) values (3, '1528547132', 'Sensor Temperatura Digital Ds18b20 Moulo -55 A 125 C Arduino')

insert into tbl_temperature_time(id, sensor_id, temperature, time) values (1, 1, 34, '2022-03-22T19:27:27.134745')
insert into tbl_temperature_time(id, sensor_id, temperature, time) values (2, 1, 35, '2022-03-22T20:27:27.134745')

insert into tbl_humidity_sensor(id, serial, name) values (1, '1435476534', 'Sensor Humedad Suelo Yl100 Higrometro Plantas Arduino')
insert into tbl_humidity_sensor(id, serial, name) values (2, '7734523651', 'Sensor De Humedad Del Suelo Higrometro')
insert into tbl_humidity_sensor(id, serial, name) values (3, '8564532687', 'Sensor De Humedad Del Suelo Higrometro Con Rele')

insert into tbl_humidity_time(id, sensor_id, humidity, time) values (1, 1, 34, '2022-03-22T19:27:27.134745')
insert into tbl_humidity_time(id, sensor_id, humidity, time) values (2, 1, 35, '2022-03-22T20:27:27.134745')

insert into tbl_radiation_sensor(id, serial, name) values (1, '8456718239', 'Sensor Ultravioleta Uvm-30a Uv Proyectos Arduino')
insert into tbl_radiation_sensor(id, serial, name) values (2, '9157323816', 'Sensor Luz Ultravioleta Uv Ml8511 Analogico 280-390nm Arduin')
insert into tbl_radiation_sensor(id, serial, name) values (3, '1020304955', 'Sensor Ultravioleta Rayos Uv Guva-s12sd 240nm-370nm Analogo')

insert into tbl_radiation_time(id, sensor_id, radiation, time) values (1, 1, 34, '2022-03-22T19:27:27.134745')
insert into tbl_radiation_time(id, sensor_id, radiation, time) values (2, 1, 35, '2022-03-22T20:27:27.134745')