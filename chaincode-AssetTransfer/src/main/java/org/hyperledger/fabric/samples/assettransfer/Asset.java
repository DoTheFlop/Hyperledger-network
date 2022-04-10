
package org.hyperledger.fabric.samples.assettransfer;

import java.util.HashMap;
import java.util.Objects;

import lombok.*;
import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

@DataType()
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public final class Asset {

    @Property()
    private String assetID;

    @Property()
    private String owner;

    @Property()
    private HashMap<String, String> coin;

    @Property()
    private String sender;

    @Property()
    private String receiver;

    @Property()
    private String amount;

    public static Asset of(final String assetID, final String owner, final HashMap<String, String> coin, final String sender, final String receiver, final String amount) {
        return new Asset(assetID, owner, coin, sender, receiver, amount);
    }

    public Asset(String assetID, String owner, HashMap<String, String> coin, String sender, String receiver, String amount) {
        this.assetID = assetID;
        this.owner = owner;
        this.coin = coin;
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asset asset = (Asset) o;
        return Objects.equals(getAssetID(), asset.getAssetID()) && Objects.equals(getOwner(), asset.getOwner()) && Objects.equals(getCoin(), asset.getCoin()) && Objects.equals(getSender(), asset.getSender()) && Objects.equals(getReceiver(), asset.getReceiver()) && Objects.equals(getAmount(), asset.getAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAssetID(), getOwner(), getCoin(), getSender(), getReceiver(), getAmount());
    }
}
