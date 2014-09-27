
--#1) per capita income and number of restaurants
SELECT c.county_name AS cn,
  c.state ,
  c.year,
  c.per_capita_income,
  SUM(r.count) AS Restaurant_count
FROM county    AS c,
  restaurant   AS r
WHERE c.county_name=r.county_name
AND c.state        =r.state
AND c.year         = r.year
GROUP BY cn,
  c.state,
  c.year;

--#3) Population of a county for a particular year along with Number of restaurants, Per capita Income and Obesity Rate
SELECT c.county_name AS cn,
  c.state ,
  c.year,
  c.per_capita_income,
  h.obesity_rate,
  h.diabetes_rate,
  SUM(r.count)     AS Restaurant_count
FROM county        AS c,
  restaurant       AS r,
  healthstatistics AS h
WHERE c.county_name=r.county_name
AND c.state        =r.state
AND c.year         = r.year
AND c.county_name  =h.county_name
AND c.state        =h.state
AND c.year         = h.year
GROUP BY cn,
  c.state,
  c.year;

--#6) Disease along with number of hospitals, poverty and death rate
SELECT c.county_name AS cn,
  c.state ,
  c.year,
  c.poverty,
  c.num_of_death AS total_number_of_death,
  h.no_of_hospitals #d.disease_name,
  #d.no_of_death
FROM county        AS c,
  #diseases        AS d,
  healthstatistics AS h #where c.county_name=d.county_name #and c.state=d.state #and c.year = d.year c.county_name=h.county_name
AND c.state                                 =h.state
AND c.year                                  = h.year
GROUP BY cn,
  c.state,
  c.year;

--#7) obesity and activity
SELECT h.county_name AS cn,
  h.state ,
  h.year,
  h.obesity_rate,
  h.excercise_rate
FROM healthstatistics AS h;


--#8) obesity rate and number of restaurant(Fast food)
SELECT h.county_name AS cn,
  h.state ,
  h.year,
  obesity_rate,
  r.count             AS Restaurant_count
FROM healthstatistics AS h,
  restaurant          AS r
WHERE h.county_name=r.county_name
AND h.state        =r.state
AND h.year         = r.year
AND r.type LIKE"Fast%"
GROUP BY cn,
  h.state,
  h.year;

  
--#9 Obesity analysis
SELECT state,
  YEAR,
  SUM(obesity_rate)/COUNT(county_name) AS average
FROM big_data.healthstatistics
GROUP BY state
ORDER BY state ASC;
