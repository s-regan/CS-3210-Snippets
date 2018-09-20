%entrees
entree(pancake).
entree(biscuits_and_gravy).
entree(breakfast_burrito).
entree(salad).
entree(sandwich).
entree(pizza).
entree(burger).
entree(pasta).
entree(steak)

%sides
side(bread).

%drinks
drink(water).
drink(soda).
drink(alcohol).

%foods that belong to a meal
breakfast(pancake).
breakfast(biscuits_and_gravy).
breakfast(breakfast_burrito).

breakfast(side,).
breakfast(side,).
breakfast(side,).

lunch(salad).
lunch(sandwich).
lunch(pizza).

lunch(side,).
lunch(side,).
lunch(side,).

dinner(burger).
dinner(pasta).
dinner(steak).

dinner(side,).
dinner(side,).
dinner(side,).

%rules
meal(X,Y,Z):-entree(X),drink(Y),side(Z).

%meal(X,Y),dinner(X). -> semi colon to continue