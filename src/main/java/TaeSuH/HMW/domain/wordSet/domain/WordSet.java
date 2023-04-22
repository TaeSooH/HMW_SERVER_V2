package TaeSuH.HMW.domain.wordSet.domain;

import TaeSuH.HMW.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
public class WordSet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wordSet_id")
    private Long id;

    @Column(name = "wordSet_title")
    private String title;

    protected WordSet() {}

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private User owner;

    @Builder
    public WordSet(Long id, String title, User owner) {
        this.id = id;
        this.title = title;
        this.owner = owner;
    }

    public void setUser(User user) {
        if(this.getOwner() != null){
            user.getWordSetList().remove(this);
        }
        this.owner = user;
        user.getWordSetList().add(this);
    }
}
