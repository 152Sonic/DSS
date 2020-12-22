use dss;

insert into Robot
	(codRobot,xRobot,yRobot,aTransp,localizacaoXRobot,localizacaoYRobot,entregue)
    values
		(1,0,0,-1,-1,-1,0)
	;

insert into paletes
	(codPaletes,x,y,transporte,materialP)
    values
		(1,1,1,-1,"Meias"),
        (2,2,4,-1,"polos"),
        (3,1,4,-1,"rojoes")
	;

insert into historico
	(codPaletes,x,y,transporte,materialP)
    values
		(1,1,1,-1,"Meias"),
        (2,2,4,-1,"polos"),
        (3,1,4,-1,"rojoes")
	;
    
insert into espera 
    (codPaletes,x,y,transporte,materialP)
    values
		(2,0,1,-1,"polos")
	;


INSERT INTO prateleiras
	(codPrateleira, disponibilidade, codPalete, x,y)
    VALUES
		(1, 1, -1, 1,0),
        (2, 0, 1, 1,1),
        (3, 1, -1, 1,2),
        (4, 1, -1, 1,3),
        (5, 0, 3, 1,4),
        (6, 1, -1, 2,0),
        (7, 1,-1, 2,1),
        (8, 1, -1, 2,2),
        (9, 1, -1, 2,3),
        (10, 0, 2, 2,4)
	;
 

