
class PlayerManager:
    players = []
    
    def add_player(self, player):
        if len(self.players) < 2:
            self.players.append(player)
        else:
            raise Exception("Too many players")
        
    def players_ready(self):
        if len(self.players) == 2:
            return True
        else:
            return False