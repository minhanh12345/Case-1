-- 3
select * from dongxe
where sochongoi>4
-- 4
select nhacungcap.* from nhacungcap
inner join dangkycungcap on dangkycungcap.maNhaCC=nhacungcap.maNhaCC
inner join dongxe on dangkycungcap.maDongXe=dongxe.maDongxe
inner join mucphi on dangkycungcap.maMucPhi=mucphi.maMucPhi
where (dongxe.hangxe='Toyota' and mucphi.dongia=15000) or(dongxe.hangxe='kia' and mucphi.dongia=20000)
-- 5
select * from nhacungcap
order by tennhaCC asc
select * from nhacungcap 
order by masothue desc
-- 6
select manhacc ,count(madkcc)as soluong
from dangkycungcap
where ngaybatdauCC='2018-06-15'
group by manhacc
-- 7
select distinct hangxe
from dongxe
-- 8
select madkcc ,dangkycungcap.manhacc,tennhacc,diachi,masothue,tenloaidv,dongia,hangxe,ngaybatdaucc,ngayketthucCC 
from dangkycungcap
join dongxe on dangkycungcap.maDongXe=Dongxe.maDongxe
  join loaidichvu on dangkycungcap.maloaiDV=loaidichvu.maloaiDV 
  join mucphi on dangkycungcap.maMucPhi=mucphi.mamucphi
  right join nhacungcap on dangkycungcap.maNhaCC=nhacungcap.maNhaCC

-- 9
select nhacungcap.*
 from nhacungcap
 inner join dangkycungcap on dangkycungcap.manhaCC=nhacungcap.manhaCC
 inner join dongxe on dangkycungcap.madongxe=dongxe.madongxe
 where dongxe.hangxe='toyota' or dongxe.hangxe='huyndai'
 -- 10
 select *
 from nhacungcap
  where manhacc not in (select maNhaCC from (select distinct nhacungcap.*
 from nhacungcap
 inner join dangkycungcap on dangkycungcap.manhaCC=nhacungcap.manhaCC) as nhacc)