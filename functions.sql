-----------Verilen kid id'ye göre devamsızlık hesaplayan fonksiyon-------------
CREATE OR REPLACE FUNCTION getTotalNonAttendance(targetKid INTEGER) RETURNS INTEGER AS $$
DECLARE
	kidTable CURSOR FOR SELECT * FROM nonAttendances WHERE kidId = targetKid;
	sumNonAttendance INTEGER;
BEGIN
	sumNonAttendance = 0;
	FOR row IN kidTable LOOP
		sumNonAttendance = sumNonAttendance + 1;
	END LOOP;
	RETURN sumNonAttendance;
END;
$$ LANGUAGE 'plpgsql';

SELECT gettotalnonattendance(101);

-----------Verilen Adreste Oturan Velilerin Öğrencileri----------------------
CREATE TYPE tableByAddresses AS (fname varchar(20), lname varchar(20), g_fname varchar(20), g_lname varchar(20), g_phone varchar(20));

CREATE OR REPLACE FUNCTION getStudentByAddress(targetAddress guardian.address%TYPE) RETURNS tableByAddresses[] AS $$
DECLARE
	list tableByAddresses[];
	i int;
	curs CURSOR FOR SELECT kd.firstname, kd.lastname, grd.firstname, grd.lastname, grd.phone FROM kid kd , guardian grd WHERE kd.kidid = grd.kidId 
																									AND grd.address =targetAddress;
BEGIN
	i:=0;
	FOR elements IN curs LOOP
		list[i] := elements;
		i:=i+1;
	END LOOP;
	RETURN list;
END;
$$ LANGUAGE 'plpgsql';

SELECT getstudentbyaddress('Kadıköy');


------------Sınıf adını parametre alıp sınıfı listeleyn fonksiyon----------
CREATE OR REPLACE FUNCTION listClass(class_name varchar(20)) RETURNS kid[] AS '
DECLARE
	curs CURSOR FOR SELECT * from kid;
	kids kid[];
	i integer := 0;
BEGIN
	for x in curs loop 
		if x.classroom = class_name then
			kids[i] = x;
			i= i +1;
		end if;
	end loop;
	RETURN kids;
END;
'LANGUAGE 'plpgsql';


------------Aynı gün içerisinde ikinci devamsızlığı engelleyen trigger------------
CREATE OR REPLACE FUNCTION attendanceTriggerFunction() RETURNS TRIGGER AS $$
DECLARE
checkId INTEGER ;
BEGIN

        SELECT kidId INTO checkId
        FROM nonAttendances
        WHERE date = NEW.date AND kidId = NEW.kidId;

        IF(checkID IS NULL) THEN
            RETURN NEW;
        END IF;

        RAISE EXCEPTION 'no';
        RETURN NULL;
END;
$$ LANGUAGE 'plpgsql';

------------Sınıfa öğrenci eklerken sınıftaki öğrenci sayısını arttıran trigger---------------
CREATE OR REPLACE FUNCTION updateClassNumOfStudentsFunc() RETURNS TRIGGER AS $$
DECLARE 
	classQuota int;
	classNumOfStudent int;
BEGIN
	SELECT quota,numOfStudent INTO classQuota,classNumOfStudent FROM classroom WHERE className = new.classroom;
	IF classQuota > classNumOfStudent THEN 
		UPDATE classroom SET numOfStudent = numOfStudent + 1 WHERE classname = new.classroom;
		RETURN NEW;
	ELSE 
		RETURN NULL;
	END IF;
END;
$$ LANGUAGE 'plpgsql';

CREATE OR REPLACE TRIGGER updateClassNumOfStudents
AFTER INSERT 
ON kid
FOR EACH ROW EXECUTE PROCEDURE updateClassNumOfStudentsFunc();

