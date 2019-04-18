Bonjour,

Je profite de ce fichier pour partager avec vous mes idées sur cette exercice:
1- Mon objectif était de répondre à votre exercice tout en respectant , SOLID , KISS et YAGNI
 a- solid : 
	- J'ai enlever le withdraw de la classe customer account car elle contient une règle métier que je la trouve en dehors de la responsabilité
	de cette classe que la considère comme un record (dto si vous voulez), les règles métiers doivent être incluses dans un manager qui manipule les comptes et les règles.
	- Pour l'interface agregation je la trouve déjà bien appliquée dans la base du code, j'avais juste à suivre en ajoutant le manager 
	- pour l'injection de dépendance je l'ai appliqué sur le manager que je considère comme un service , 
	même chose pour les règles qui sont un comportement et pas un état donc je les ai injecté aussi on les considérant comme étant un service. 
	Et j'ai choisi google Juice car c'est léger , et avec  , 
	l'injection aussi au niveau des tests était volontaire au lieu de créer des spy (ies) .

 b-kiss et Yagni : si le premier principe m'oblige à mettre un code simple , le deuxième m'a un peu gêné avec le test car le principe lui même de ce test technique 
 est de laisser aller mon imagination , mais en respectant la règle Yagni je devais me restreindre aux fonctionnalités demandées et de ne pas m'aventurer sur d'autres fonctionnalités surtout que je n'ai pas d’énoncé ou de User stories.  

 2- Mockito me semble une évidence pour moi surtout que je voulais pas creer une méthode setBalance dans Account qui change l’accès à l'attribut balance, je voulais pas qu'on surcharge la valeur de la balance directement mais plutôt ajouter ou soustraire seulement.
 
 * Si vous avez des questions vous pouvez me contactez sur khaled.benari@gmail.com
 
 merci d'avoir lu