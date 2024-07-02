# RatsInSpace
RPG Simulator

## How to start the game:
- gradle run
- 
## Design Patterns
- The SpaceStation class uses the singleton pattern. It stores all of the floors generated in the game and the special top floor.
- The PCFactory uses the factory pattern. It creates a player character based on the user’s input. The user can input a name and then select a character class and type. The PCFactory takes this data and creates player character which is then passed into the new game.
- The CycleFactory uses the flyweight factory pattern. I handles the creation and deletion of cycles, parts and floors as the user plays.
  https://www.geeksforgeeks.org/gang-of-four-gof-design-patterns/
- https://refactoring.guru/design-patterns/flyweight
## Screencast
[screencast link](https://www.youtube.com/watch?v=Kkpm0Jeq6F4)

Checklist
- [x] You can choose from three character classes: biter, thief, wizard.
- [x] You can choose from three character types: pouchedrat, fancyrat, woodrat.
- [x] Each class has a unique list of skills.
- [x] Each type comes with proficiency bonuses that get added to player stats when player is created.
- [x] Each floor has an enemy. Every 5th floor has a medium level enemy. Every 10th floor has a boss. All other floors have a small enemy.
- [x] You can equip 3 items. To equip an item you must not already have that item.
- [x] After each battle you have a small chance to find treasure(SpaceJunk) or a shop.
- [x] Potions(SuperPacks) can never give more health than player max (20).
- [x] If your health is below 15% (3) you get sent back to the top floor which restores your health to 20.
- [ ] Enemies get harder to defeat (more hp) every floor.
- [x] The game runs on cycles made up of 4 parts. Each part is 3 floors.
- [ ] Each part has it's own event i.e. physical attacks always deal X less damage
- [x] Character has the following stats: attack, health, mana, defense, speed
- [x] Character has at least one skill.
- [x] All attacks have a chance to fail/miss.
- [x] Attacks deal a min of 1 damage (small enemy), 2 damage (medium enemy), 3 damage (boss).
- [x] You gain experience for winning battles and can level up.
- [ ] When you level up  you can choose a specific skill to upgrade. 
- [x] Leveling up sends you back to the top floor
- [x] During combat attacks and item usage happen in a turn based fashion
- [ ] During combat the participant with the highest speed goes first
- [ ] When a player goes under 15% hp,they go to the top floor medbay and lose money (my rats don't use money)
- [x] During a players turn they can attack or use a consumable.
- [ ] NPCs can use consumables.
- [x] game include temporary status effects (spacesuits and safety tethers can be equipped as armor and temp increase hp until dropped/unequipped)