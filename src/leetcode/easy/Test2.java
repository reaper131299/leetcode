package leetcode.easy;

import java.nio.charset.StandardCharsets;

public class Test2 {

    public static void main(String args[]){
        Test2 t = new Test2();
        t.toHexString("<SendDebitCreditNoteRequestType xmlns:prx=\"urn:sap.com:proxy:ED2:/1SAI/TAS0FA3F48DCF3DF4A2BBB6:758\" xmlns:n0=\"http://www.w3.org/2000/09/xmldsig#\" xmlns:n1=\"urn:etda:uncefact:data:standard:DebitCreditNote_CrossIndustryInvoice:2\" xmlns:n2=\"urn:etda:uncefact:data:standard:DebitCreditNote_ReusableAggregateBusinessInformationEntity:2\">\n" +
                "<Body>\n" +
                "<n1:ExchangedDocumentContext>\n" +
                "<n2:GuidelineSpecifiedDocumentContextParameter>\n" +
                "<n2:ID schemeAgencyID=\"ETDA\" schemeVersionID=\"v2.0\">TESTID</n2:ID>\n" +
                "</n2:GuidelineSpecifiedDocumentContextParameter>\n" +
                "</n1:ExchangedDocumentContext>\n" +
                "<n1:ExchangedDocument>\n" +
                "<n2:ID>TEST</n2:ID>\n" +
                "<n2:Name languageID=\"EN\">Credit note</n2:Name>\n" +
                "<n2:TypeCode>81</n2:TypeCode>\n" +
                "<n2:IssueDateTime>2026-04-29T09:46:56Z</n2:IssueDateTime>\n" +
                "<n2:Purpose>WRONG BILLABLE</n2:Purpose>\n" +
                "<n2:PurposeCode>CDNG99</n2:PurposeCode>\n" +
                "<n2:GlobalID>13df099a-820d-4fb4-b8ec-3fddcf</n2:GlobalID>\n" +
                "<n2:CreationDateTime>2026-04-30T06:19:59Z</n2:CreationDateTime>\n" +
                "</n1:ExchangedDocument>\n" +
                "<n1:SupplyChainTradeTransaction>\n" +
                "<n2:ApplicableHeaderTradeAgreement>\n" +
                "<n2:SellerTradeParty>\n" +
                "<n2:ID>1786</n2:ID>\n" +
                "<n2:Name>Ford Sales Svc Thailand</n2:Name>\n" +
                "<n2:SpecifiedTaxRegistration>\n" +
                "<n2:ID schemeID=\"TXID\">0105542083438</n2:ID>\n" +
                "</n2:SpecifiedTaxRegistration>\n" +
                "<n2:PostalTradeAddress>\n" +
                "<n2:CountryID>TH</n2:CountryID>\n" +
                "</n2:PostalTradeAddress>\n" +
                "</n2:SellerTradeParty>\n" +
                "<n2:BuyerTradeParty>\n" +
                "<n2:ID>TH_52600</n2:ID>\n" +
                "<n2:Name>C.F. Autocars Co.,Ltd.</n2:Name>\n" +
                "<n2:SpecifiedTaxRegistration>\n" +
                "<n2:ID schemeID=\"Other\">N/A</n2:ID>\n" +
                "</n2:SpecifiedTaxRegistration>\n" +
                "<n2:PostalTradeAddress>\n" +
                "<n2:PostcodeCode>96000</n2:PostcodeCode>\n" +
                "<n2:LineOne>104/4 Suriya Pradit Road</n2:LineOne>\n" +
                "<n2:CountryID>TH</n2:CountryID>\n" +
                "</n2:PostalTradeAddress>\n" +
                "</n2:BuyerTradeParty>\n" +
                "<n2:BuyerOrderReferencedDocument>\n" +
                "<n2:IssuerAssignedID>1155A</n2:IssuerAssignedID>\n" +
                "</n2:BuyerOrderReferencedDocument>\n" +
                "<n2:AdditionalReferencedDocument>\n" +
                "<n2:IssuerAssignedID>6210000026</n2:IssuerAssignedID>\n" +
                "<n2:IssueDateTime>2026-04-29T00:00:00Z</n2:IssueDateTime>\n" +
                "</n2:AdditionalReferencedDocument>\n" +
                "<n2:AdditionalReferencedDocument>\n" +
                "<n2:IssuerAssignedID>6210000026</n2:IssuerAssignedID>\n" +
                "<n2:IssueDateTime>2026-04-29T00:00:00Z</n2:IssueDateTime>\n" +
                "</n2:AdditionalReferencedDocument>\n" +
                "</n2:ApplicableHeaderTradeAgreement>\n" +
                "<n2:ApplicableHeaderTradeDelivery>\n" +
                "<n2:ShipToTradeParty>\n" +
                "<n2:ID>TH_52600</n2:ID>\n" +
                "<n2:Name>C.F. Autocars Co.,Ltd.</n2:Name>\n" +
                "<n2:SpecifiedTaxRegistration>\n" +
                "<n2:ID schemeID=\"TXID\">011554100268000001</n2:ID>\n" +
                "</n2:SpecifiedTaxRegistration>\n" +
                "<n2:PostalTradeAddress>\n" +
                "<n2:PostcodeCode>96000</n2:PostcodeCode>\n" +
                "<n2:LineOne>104/4 Suriya Pradit Road</n2:LineOne>\n" +
                "<n2:CountryID>TH</n2:CountryID>\n" +
                "</n2:PostalTradeAddress>\n" +
                "</n2:ShipToTradeParty>\n" +
                "</n2:ApplicableHeaderTradeDelivery>\n" +
                "<n2:ApplicableHeaderTradeSettlement>\n" +
                "<n2:ApplicableTradeTax>\n" +
                "<n2:TypeCode>VAT</n2:TypeCode>\n" +
                "<n2:CalculatedRate>7.0</n2:CalculatedRate>\n" +
                "<n2:BasisAmount currencyID=\"THB\">800.0</n2:BasisAmount>\n" +
                "<n2:CalculatedAmount currencyID=\"THB\">56.0</n2:CalculatedAmount>\n" +
                "</n2:ApplicableTradeTax>\n" +
                "<n2:SpecifiedTradePaymentTerms />\n" +
                "<n2:SpecifiedTradeSettlementHeaderMonetarySummation>\n" +
                "<n2:OriginalInformationAmount>1000.0</n2:OriginalInformationAmount>\n" +
                "<n2:LineTotalAmount currencyID=\"THB\">200.0</n2:LineTotalAmount>\n" +
                "<n2:DifferenceInformationAmount>0.0</n2:DifferenceInformationAmount>\n" +
                "<n2:AllowanceTotalAmount>0.0</n2:AllowanceTotalAmount>\n" +
                "<n2:ChargeTotalAmount>0.0</n2:ChargeTotalAmount>\n" +
                "<n2:TaxBasisTotalAmount currencyID=\"THB\">800.0</n2:TaxBasisTotalAmount>\n" +
                "<n2:TaxTotalAmount currencyID=\"THB\">56.0</n2:TaxTotalAmount>\n" +
                "<n2:GrandTotalAmount currencyID=\"THB\">800.0</n2:GrandTotalAmount>\n" +
                "</n2:SpecifiedTradeSettlementHeaderMonetarySummation>\n" +
                "<n2:InvoiceeTradeParty>\n" +
                "<n2:ID>TH_52600</n2:ID>\n" +
                "<n2:Name>C.F. Autocars Co.,Ltd.</n2:Name>\n" +
                "<n2:SpecifiedTaxRegistration>\n" +
                "<n2:ID schemeID=\"TXID\">011554100268000001</n2:ID>\n" +
                "</n2:SpecifiedTaxRegistration>\n" +
                "<n2:PostalTradeAddress>\n" +
                "<n2:PostcodeCode>96000</n2:PostcodeCode>\n" +
                "<n2:LineOne>104/4 Suriya Pradit Road</n2:LineOne>\n" +
                "<n2:CountryID>TH</n2:CountryID>\n" +
                "</n2:PostalTradeAddress>\n" +
                "</n2:InvoiceeTradeParty>\n" +
                "<n2:PayerTradeParty>\n" +
                "<n2:ID>TH_52600</n2:ID>\n" +
                "<n2:Name>C.F. Autocars Co.,Ltd.</n2:Name>\n" +
                "<n2:SpecifiedTaxRegistration>\n" +
                "<n2:ID schemeID=\"TXID\">011554100268000001</n2:ID>\n" +
                "</n2:SpecifiedTaxRegistration>\n" +
                "<n2:PostalTradeAddress>\n" +
                "<n2:PostcodeCode>96000</n2:PostcodeCode>\n" +
                "<n2:LineOne>104/4 Suriya Pradit Road</n2:LineOne>\n" +
                "<n2:CountryID>TH</n2:CountryID>\n" +
                "</n2:PostalTradeAddress>\n" +
                "</n2:PayerTradeParty>\n" +
                "</n2:ApplicableHeaderTradeSettlement>\n" +
                "<n2:IncludedSupplyChainTradeLineItem>\n" +
                "<n2:AssociatedDocumentLineDocument>\n" +
                "<n2:LineID>                                 1</n2:LineID>\n" +
                "</n2:AssociatedDocumentLineDocument>\n" +
                "<n2:SpecifiedTradeProduct>\n" +
                "<n2:ID>M-23R003916-S</n2:ID>\n" +
                "<n2:Name>Lease car</n2:Name>\n" +
                "<n2:Description>Lease car</n2:Description>\n" +
                "<n2:IndividualTradeProductInstance />\n" +
                "<n2:OriginTradeCountry>\n" +
                "<n2:ID>TH</n2:ID>\n" +
                "</n2:OriginTradeCountry>\n" +
                "</n2:SpecifiedTradeProduct>\n" +
                "<n2:SpecifiedLineTradeAgreement>\n" +
                "<n2:GrossPriceProductTradePrice>\n" +
                "<n2:ChargeAmount currencyID=\"THB\">80.0</n2:ChargeAmount>\n" +
                "</n2:GrossPriceProductTradePrice>\n" +
                "</n2:SpecifiedLineTradeAgreement>\n" +
                "<n2:SpecifiedLineTradeDelivery>\n" +
                "<n2:BilledQuantity>10.000 </n2:BilledQuantity>\n" +
                "<n2:PerPackageUnitQuantity>0 </n2:PerPackageUnitQuantity>\n" +
                "</n2:SpecifiedLineTradeDelivery>\n" +
                "<n2:SpecifiedLineTradeSettlement>\n" +
                "<n2:ApplicableTradeTax>\n" +
                "<n2:TypeCode>VAT</n2:TypeCode>\n" +
                "<n2:CalculatedRate>7.0</n2:CalculatedRate>\n" +
                "<n2:BasisAmount currencyID=\"THB\">800.0</n2:BasisAmount>\n" +
                "<n2:CalculatedAmount currencyID=\"THB\">56.0</n2:CalculatedAmount>\n" +
                "</n2:ApplicableTradeTax>\n" +
                "<n2:SpecifiedTradeSettlementLineMonetarySummation>\n" +
                "<n2:TaxTotalAmount currencyID=\"THB\">56.0</n2:TaxTotalAmount>\n" +
                "<n2:NetLineTotalAmount currencyID=\"THB\">800.0</n2:NetLineTotalAmount>\n" +
                "<n2:NetIncludingTaxesLineTotalAmount currencyID=\"THB\">856.0</n2:NetIncludingTaxesLineTotalAmount>\n" +
                "</n2:SpecifiedTradeSettlementLineMonetarySummation>\n" +
                "</n2:SpecifiedLineTradeSettlement>\n" +
                "</n2:IncludedSupplyChainTradeLineItem>\n" +
                "</n1:SupplyChainTradeTransaction>\n" +
                "</Body>\n" +
                "<transactionID />\n" +
                "</SendDebitCreditNoteRequestType>");
    }

    public String toHexString(String input) {
        if (input == null) {
            return null;
        }

        StringBuilder hexBuilder = new StringBuilder();
        byte[] bytes = input.getBytes(StandardCharsets.UTF_8);

        for (byte b : bytes) {
            // Format each byte as a 2-character hexadecimal string
            hexBuilder.append(String.format("%02x", b));
        }

        String result =  hexBuilder.toString();
        System.out.println(result);
        return result;
    }
}
