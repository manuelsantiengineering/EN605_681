SELECT reservation.First, reservation.Last, reservation.NumberOfDays, locations.location, guides.First, guides.Last 
FROM reservation, guides, locations 
WHERE reservation.guide = guides.idguides 
AND reservation.location = locations.idlocations;