﻿select  r.descripcion, sum(m.cantidad) from rubro r, movimiento m, subrubro sr where m.PK_subrubro=sr.PK_subrubro and sr.PK_rubro=r.PK_rubro and m.fecha between '2001-01-01' and '2016-04-20' GROUP BY  r.descripcion