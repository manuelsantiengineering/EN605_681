SELECT reservation.idreservation, reservation.First, reservation.Last, 
reservation.StartDay, reservation.NumberOfDays, guides.First, guides.Last, locations.location  
FROM reservation, guides, locations 
WHERE reservation.guide = guides.idguides 
AND reservation.location = locations.idlocations
AND reservation.StartDay = "2021-08-01";