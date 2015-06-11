Android.dbschema do
    create_table( :TestTable ) do
        primary_key :id
        String :name
        Integer :age
        DateTime :birthday
        String :nullField
    end
end
